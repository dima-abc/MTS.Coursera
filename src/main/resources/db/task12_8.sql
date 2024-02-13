--Количество пользователей, которые не создали ни одного поста.
EXPLAIN (format JSON, ANALYZE)
    SELECT count(pr.profile_id)
    FROM profile AS pr
    where pr.profile_id NOT IN
          (select po.profile_id FROM post AS po);
--Выберите ID всех постов по возрастанию, у которых 2 комментария, title начинается с цифры, а длина content больше 20.
EXPLAIN (format JSON, ANALYZE)
    SELECT po.*
    FROM post AS po
        INNER JOIN comment AS co
            ON co.post_id = po.post_id AND po.title SIMILAR TO '[0-9]%' AND length(po.content) > 20
    GROUP BY po.post_id
    HAVING count(co.post_id) = 2
    ORDER BY po.post_id ASC;
--Выберите первые 3 ID постов по возрастанию, у которых либо нет комментариев, либо он один.
EXPLAIN (format JSON, ANALYZE)
    SELECT po.*
    FROM post AS po
        INNER JOIN comment AS co ON co.post_id = po.post_id
    GROUP BY po.post_id
    HAVING count(co.comment_id) <= 1
    ORDER BY po.post_id ASC
    LIMIT 3;
--Скрипты для создания и заполнения таблиц
--Скрипт создания таблиц:
CREATE TABLE profile
(
    profile_id      BIGINT PRIMARY KEY,
    login           VARCHAR(200)             NOT NULL,
    date_registered TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE post
(
    post_id    BIGINT PRIMARY KEY,
    title      VARCHAR(200)                           NOT NULL,
    content    TEXT                                   NOT NULL,
    profile_id BIGINT REFERENCES profile (profile_id) NOT NULL,
    date_added TIMESTAMP WITH TIME ZONE               NOT NULL
);

CREATE TABLE comment
(
    comment_id     BIGINT PRIMARY KEY,
    post_id        BIGINT REFERENCES post (post_id)       NOT NULL,
    profile_id     BIGINT REFERENCES profile (profile_id) NOT NULL,
    date_commented TIMESTAMP WITH TIME ZONE               NOT NULL
);
--Скрипт создания тестовых данных:
CREATE OR REPLACE PROCEDURE insertComment(comment_id BIGINT, post_id BIGINT, profile_id BIGINT)
    LANGUAGE plpgsql
AS
$$
BEGIN

    INSERT INTO comment(comment_id, post_id, profile_id, date_commented)
    VALUES (comment_id, post_id, profile_id, CURRENT_TIMESTAMP);
END;
$$;

do
$$
    BEGIN
        FOR profile_id in 1..55
            LOOP
                INSERT INTO profile(profile_id, login, date_registered)
                VALUES (profile_id, 'login' || profile_id, CURRENT_TIMESTAMP);
            END LOOP;
        FOR post_id in 1..50
            LOOP
                INSERT INTO post(post_id, title, content, profile_id, date_added)
                VALUES (post_id,
                        CASE WHEN post_id % 2 = 0 THEN post_id || 'post' ELSE 'post' || post_id END,
                        repeat('a', post_id),
                        post_id,
                        CURRENT_TIMESTAMP);
            END LOOP;
        FOR comment_id in 1..50
            LOOP
                IF comment_id <= 45
                THEN
                    CALL insertComment(comment_id, comment_id, comment_id);
                ELSE
                    CONTINUE;
                END IF;

                IF comment_id % 2 = 0
                THEN
                    CALL insertComment(comment_id * 100, comment_id, comment_id);
                END IF;

                if comment_id % 10 = 0
                THEN
                    CALL insertComment(comment_id * 1000, comment_id, comment_id);
                END IF;
            END LOOP;
    END
$$;