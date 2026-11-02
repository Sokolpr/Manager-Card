CREATE TABLE cards
(
    id          uuid                     not null,
    pan         varchar(20)              not null,
    pin         varchar(4)               not null,
    cvv         varchar(4)               not null,
    user_id     uuid                     not null,
    balance     numeric(19, 4)           not null,
    card_status varchar(20)              not null,
    exp_year    int                      not null,
    exp_month   int                      not null,
    created_at  timestamp with time zone not null,
    blocked_at  timestamp with time zone not null,
    updatedAt   timestamp with time zone not null,


    constraint pk_cards PRIMARY KEY (id),
    constraint fk_card_user foreign key (user_id) references users (id)
);

create index idx_user_status on cards (pan);
create index idx_user_status on cards (card_status);
create unique index uk_pan_card on cards (pan);

COMMENT ON TABLE cards IS 'Пользователь форума: локальная проекция пользователя из сервисов Auth и Profile.';

COMMENT ON COLUMN cards.id IS 'Уникальный идентификатор записи (UUID v7, генерируется приложением).';
COMMENT ON COLUMN cards.pan IS 'pan карты, генерируется в приложении.';
COMMENT ON COLUMN cards.pin IS 'pin карты, задает пользователь';
COMMENT ON COLUMN cards.cvv IS 'cvv карты, генерируется в приложении.';
COMMENT ON COLUMN cards.balance IS 'Баланс пользователя.';
COMMENT ON COLUMN cards.card_status IS 'Статус карты.';
COMMENT ON COLUMN cards.exp_year IS 'До какого месяца обслуживается карта.';
COMMENT ON COLUMN cards.exp_month IS 'До какого года обслуживается карта.';
COMMENT ON COLUMN cards.created_at IS 'Дата и время создания пользователя. Заполняется приложением автоматически.';
COMMENT ON COLUMN cards.created_at IS 'Дата и время блокировки карты. Заполняется приложением автоматически.';
COMMENT ON COLUMN cards.created_at IS 'Дата и время обновления еарты. Заполняется приложением автоматически.';