package com.sparta.blogapp.repository;

import com.sparta.blogapp.entity.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ArticleRepositoryImpl implements ArticleRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Article create(Article entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO article (title, author, content, created_at, password) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update( con -> {
                    PreparedStatement preparedStatement = con.prepareStatement(sql,
                            Statement.RETURN_GENERATED_KEYS);

                    preparedStatement.setString(1, entity.getTitle());
                    preparedStatement.setString(2, entity.getAuthor());
                    preparedStatement.setString(3, entity.getContent());
                    preparedStatement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
                    preparedStatement.setString(5, entity.getPassword());
                    return preparedStatement;
                },
                keyHolder);

        Long id = keyHolder.getKeyAs(Long.class);
        entity.setId(id);

        return entity;
    }

    @Override
    public List<Article> findAll() {
        String sql = "SELECT * FROM blog ORDER BY created_at DESC";
        return jdbcTemplate.query(sql, Article::fromResultSet);
    }

    @Override
    public Optional<Article> findById(Long id) {
        String sql = "SELECT * FROM blog WHERE id = ?";

        Article entity = jdbcTemplate.query(sql,
                rs -> rs.next() ?
                        Article.fromResultSet(rs, 0) :
                        null,
                id);
        return Optional.ofNullable(entity);
    }

    @Override
    public Optional<Article> updateById(Long id, Article entity) {
        String sql = "UPDATE blog SET title = ?, author = ?, content = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                entity.getTitle(), entity.getAuthor(), entity.getContent(),
                id);
        return findById(id);
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM blog WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}