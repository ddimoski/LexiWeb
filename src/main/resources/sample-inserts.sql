insert into words (name)
values ('црешна'), ('полжав'), ('цртеж'), ('жаба'), ('телевизор'), ('машина'), ('речник'), ('молив'), ('радост'),
    ('тага'), ('тетратка'), ('планина'), ('извор'), ('лисица'), ('еднорог'), ('езеро'), ('растение'), ('програма'),
    ('желба'), ('желка'), ('доктор'), ('пожарникар'), ('песна'), ('магија'), ('непослушен'), ('лилјак'), ('свири'),
    ('инструмент'), ('гитара'), ('поплава'), ('виножито'), ('зелена'), ('црвена'), ('појадок'), ('ручек'), ('вечера');

insert into tests (name) values ('Тест 1');

insert into words(name) values ('прегратка');

insert into questions (main_word_id, matching_word_id)
values ((select id from words where name = 'тетратка'), (select id from words where name = 'прегратка'));

insert into questions_incorrect_words (question_id, incorrect_words_id)
values ((select id from questions where main_word_id = (select id from words where name = 'тетратка') and
        matching_word_id = (select id from words where name = 'прегратка')),
        (select id from words where name = 'зелена')),

    ((select id from questions where main_word_id = (select id from words where name = 'тетратка') and
            matching_word_id = (select id from words where name = 'прегратка')),
     (select id from words where name = 'вечера')),

    ((select id from questions where main_word_id = (select id from words where name = 'тетратка') and
            matching_word_id = (select id from words where name = 'прегратка')),
     (select id from words where name = 'телевизор'));

insert into tests_questions (test_id, questions_id)
values ((select id from tests where name = 'Тест 1'),
        (select id from questions where main_word_id = (select id from words where name = 'тетратка') and
                matching_word_id = (select id from words where name = 'прегратка')));