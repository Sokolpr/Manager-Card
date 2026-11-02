CREATE TABLE users
(
    id          uuid                     not null,
    auth_user_id  uuid                     not null,
    status  varchar(20)              not null,
    name    varchar(100)             not null,
    surname varchar(100)             not null,
    created_at  timestamp with time zone not null,

    constraint pk_card_users PRIMARY KEY (id)

);

create index idx_user_status on users (auth_user_id);
create index idx_user_status on users (status);

COMMENT ON TABLE users IS 'Пользователь форума: локальная проекция пользователя из сервисов Auth и Profile.';

COMMENT ON COLUMN users.id IS 'Уникальный идентификатор записи (UUID v7, генерируется приложением).';
COMMENT ON COLUMN users.auth_user_id IS 'UUID пользователя в Auth-сервисе (внешний ключ логической связки).';
COMMENT ON COLUMN users.status IS 'Статус пользователя';
COMMENT ON COLUMN users.name IS 'Имя пользователя для создания карт.';
COMMENT ON COLUMN users.surname IS 'Фамилия пользователя для создания карт.';
COMMENT ON COLUMN users.created_at IS 'Дата и время создания пользователя. Заполняется приложением автоматически.';