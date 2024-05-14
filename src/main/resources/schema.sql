-- src/main/resources/schema.sql

CREATE TABLE IF NOT EXISTS performance
(
    id         BINARY(16)                     NOT NULL,
    name       VARCHAR(255)                   NOT NULL,
    price      INT                            NOT NULL,
    round      INT                            NOT NULL,
    type       INT                            NOT NULL,
    start_date DATE                           NOT NULL,
    is_reserve VARCHAR(255) DEFAULT 'disable' NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS performance_discount_policy_info
(
    id             BIGINT AUTO_INCREMENT,
    performance_id BINARY(16)   NOT NULL,
    name           VARCHAR(255) NOT NULL,
    type           VARCHAR(255) NOT NULL,
    rate           DECIMAL(19, 2),
    discount_fee   INT,
    started_at     DATE         NOT NULL,
    ended_at       DATE         NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (performance_id) REFERENCES performance (id)
);
