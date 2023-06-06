CREATE TABLE payee
(   uuid  UUID NOT NULL primary key ,
    value  DECIMAL not null ,
    payeeType VARCHAR not null
);
CREATE TABLE payee_props
(   uuid  UUID NOT NULL primary key ,
    name varchar not null ,
    value varchar not null ,
    payee_id UUID references payee(uuid)
);
