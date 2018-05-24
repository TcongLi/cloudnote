CREATE TABLE cloudnote_user_type (
    user_type_id int AUTO_INCREMENT PRIMARY KEY,
    user_type_code char(42) NOT NULL,
    user_type_name char(42) NOT NULL,
    user_type_desc char(42) NOT NULL,
    user_type_max_note int NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cloudnote_user (
    user_id int AUTO_INCREMENT PRIMARY KEY,
    user_name char(42) NOT NULL,
    user_email char(42) NOT NULL,
    user_password char(42) NOT NULL,
    user_type_id int NOT NULL,
    FOREIGN KEY(user_type_id) REFERENCES cloudnote_user_type(user_type_id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cloudnote_notebook (
    notebook_id int AUTO_INCREMENT PRIMARY KEY,
    owner_id int NOT NULL,
    notebook_name char(42) NOT NULL,
    notebook_desc char(42) NOT NULL,
    is_deleted tinyint DEFAULT 0,
    is_stared tinyint DEFAULT 0,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL,
    FOREIGN KEY(owner_id) REFERENCES cloudnote_user(user_id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cloudnote_notepage (
    notepage_id int AUTO_INCREMENT PRIMARY KEY,
    notebook_id int NOT NULL,
    owner_id int NOT NULL,
    title char(42),
    content text,
    is_deleted tinyint DEFAULT 0,
    is_stared tinyint DEFAULT 0,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NOT NULL,
    FOREIGN KEY(notebook_id) REFERENCES cloudnote_notebook(notebook_id) ON DELETE CASCADE,
    FOREIGN KEY(owner_id) REFERENCES cloudnote_user(user_id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cloudnote_group (
    group_id int AUTO_INCREMENT PRIMARY KEY,
    group_owner_id int NOT NULL,
    group_name char(42) NOT NULL,
    group_desc char(42) NOT NULL,
    FOREIGN KEY(group_owner_id) REFERENCES cloudnote_user(user_id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cloudnote_group_member (
    group_member_id int AUTO_INCREMENT PRIMARY KEY,
    group_id int NOT NULL,
    user_id int NOT NULL,
    FOREIGN KEY(group_id) REFERENCES cloudnote_group(group_id) ON DELETE CASCADE,
    FOREIGN KEY(user_id) REFERENCES cloudnote_user(user_id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cloudnote_group_notepage (
    group_notepage_id int AUTO_INCREMENT PRIMARY KEY,
    group_id int NOT NULL,
    notepage_id int NOT NULL,
    FOREIGN KEY(group_id) REFERENCES cloudnote_group(group_id) ON DELETE CASCADE,
    FOREIGN KEY(notepage_id) REFERENCES cloudnote_notepage(notepage_id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
