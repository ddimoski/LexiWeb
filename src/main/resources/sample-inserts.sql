insert into words (name)
values ('црешна'), ('полжав'), ('цртеж'), ('жаба'), ('телевизор'), ('машина'), ('речник'), ('молив'), ('радост'),
    ('тага'), ('тетратка'), ('планина'), ('извор'), ('лисица'), ('еднорог'), ('езеро'), ('растение'), ('програма'),
    ('желба'), ('желка'), ('доктор'), ('пожарникар'), ('песна'), ('магија'), ('непослушен'), ('лилјак'), ('свири'),
    ('инструмент'), ('гитара'), ('поплава'), ('виножито'), ('зелена'), ('црвена'), ('појадок'), ('ручек'), ('вечера'),
    ('крава'), ('вистина'), ('приказна'), ('чудовиште'), ('празник'), ('тврдоглав'), ('насмевка'), ('ноќ'), ('бура'),
    ('торнадо'), ('енциклопедија'), ('комедија');

insert into tests (name) values ('Тест 1');

-- First question/word
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

-- Second Question
insert into words(name) values ('младост');

insert into questions (main_word_id, matching_word_id)
values ((select id from words where name = 'младост'), (select id from words where name = 'радост'));

insert into questions_incorrect_words (question_id, incorrect_words_id)
values ((select id from questions where main_word_id = (select id from words where name = 'младост') and
        matching_word_id = (select id from words where name = 'радост')),
        (select id from words where name = 'цртеж')),

    ((select id from questions where main_word_id = (select id from words where name = 'младост') and
            matching_word_id = (select id from words where name = 'радост')),
     (select id from words where name = 'лисица')),

    ((select id from questions where main_word_id = (select id from words where name = 'младост') and
            matching_word_id = (select id from words where name = 'радост')),
     (select id from words where name = 'тага'));

insert into tests_questions (test_id, questions_id)
values ((select id from tests where name = 'Тест 1'),
        (select id from questions where main_word_id = (select id from words where name = 'младост') and
                matching_word_id = (select id from words where name = 'радост')));

-- Third Question
insert into words(name) values ('баба');

insert into questions (main_word_id, matching_word_id)
values ((select id from words where name = 'жаба'), (select id from words where name = 'баба'));

insert into questions_incorrect_words (question_id, incorrect_words_id)
values ((select id from questions where main_word_id = (select id from words where name = 'жаба') and
        matching_word_id = (select id from words where name = 'баба')),
        (select id from words where name = 'приказна')),

    ((select id from questions where main_word_id = (select id from words where name = 'жаба') and
            matching_word_id = (select id from words where name = 'баба')),
     (select id from words where name = 'вистина')),

    ((select id from questions where main_word_id = (select id from words where name = 'жаба') and
            matching_word_id = (select id from words where name = 'баба')),
     (select id from words where name = 'тврдоглав'));

insert into tests_questions (test_id, questions_id)
values ((select id from tests where name = 'Тест 1'),
        (select id from questions where main_word_id = (select id from words where name = 'жаба') and
                matching_word_id = (select id from words where name = 'баба')));

-- Fourth Question
insert into questions (main_word_id, matching_word_id)
values ((select id from words where name = 'енциклопедија'), (select id from words where name = 'комедија'));

insert into questions_incorrect_words (question_id, incorrect_words_id)
values ((select id from questions where main_word_id = (select id from words where name = 'енциклопедија') and
        matching_word_id = (select id from words where name = 'комедија')),
        (select id from words where name = 'бура')),

    ((select id from questions where main_word_id = (select id from words where name = 'енциклопедија') and
            matching_word_id = (select id from words where name = 'комедија')),
     (select id from words where name = 'насмевка')),

    ((select id from questions where main_word_id = (select id from words where name = 'енциклопедија') and
            matching_word_id = (select id from words where name = 'комедија')),
     (select id from words where name = 'торнадо'));

insert into tests_questions (test_id, questions_id)
values ((select id from tests where name = 'Тест 1'),
        (select id from questions where main_word_id = (select id from words where name = 'енциклопедија') and
                matching_word_id = (select id from words where name = 'комедија')));