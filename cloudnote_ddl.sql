DROP TABLE IF EXISTS cloudnote_user_type;
CREATE TABLE cloudnote_user_type (
    user_type_id int AUTO_INCREMENT PRIMARY KEY,
    user_type_code char(42) NOT NULL COMMENT '用户类型编码',
    user_type_name char(42) NOT NULL COMMENT '用户类型名称',
    user_type_desc char(42) NOT NULL COMMENT '用户类型描述',
    user_type_max_note int NOT NULL COMMENT '该用户类型最大可创建的笔记条数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户类型表';

DROP TABLE IF EXISTS cloudnote_user;
CREATE TABLE cloudnote_user (
    user_id int AUTO_INCREMENT PRIMARY KEY,
    user_name char(42) NOT NULL COMMENT '用户名',
    user_password char(42) NOT NULL COMMENT '密码',
    user_type_id int NOT NULL COMMENT '用户类型id',
    FOREIGN KEY(user_type_id) REFERENCES cloudnote_user_type(user_type_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

DROP TABLE IF EXISTS cloudnote_notebook;
CREATE TABLE cloudnote_notebook (
    notebook_id int AUTO_INCREMENT PRIMARY KEY,
    owner_id int NOT NULL COMMENT '笔记本属主id',
    notebook_name char(42) NOT NULL COMMENT '笔记本名',
    notebook_desc char(42) NOT NULL COMMENT '笔记本描述',
    is_deleted tinyint DEFAULT 0 COMMENT '删除标记',
    is_stared tinyint DEFAULT 0 COMMENT '加星标记',
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at timestamp COMMENT '修改时间',
    FOREIGN KEY(owner_id) REFERENCES cloudnote_user(user_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='笔记本表';

DROP TABLE IF EXISTS cloudnote_notepage;
CREATE TABLE cloudnote_notepage (
    notepage_id int AUTO_INCREMENT PRIMARY KEY,
    notebook_id int NOT NULL COMMENT '所属笔记本id',
    owner_id int NOT NULL COMMENT '属主id',
    title char(42) COMMENT '页标题',
    content text COMMENT '页内容',
    is_deleted tinyint DEFAULT 0 COMMENT '删除标记',
    is_stared tinyint DEFAULT 0 COMMENT '加星标记',
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at timestamp COMMENT '修改时间',
    FOREIGN KEY(notebook_id) REFERENCES cloudnote_notebook(notebook_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(owner_id) REFERENCES cloudnote_user(user_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='笔记页表';

DROP TABLE IF EXISTS cloudnote_group;
CREATE TABLE cloudnote_group (
    groups_id int AUTO_INCREMENT PRIMARY KEY,
    group_owner_id int COMMENT '组创建者id',
    group_name char(42) NOT NULL COMMENT '组名',
    group_desc char(42) NOT NULL COMMENT '组描述',
    FOREIGN KEY(group_owner_id) REFERENCES cloudnote_user(user_id) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户小组基本信息表';

DROP TABLE IF EXISTS cloudnote_group_member;
CREATE TABLE cloudnote_group_member (
    group_member_id int AUTO_INCREMENT PRIMARY KEY,
    groups_id int NOT NULL COMMENT '用户属组id',
    user_id int NOT NULL COMMENT '用户id',
    FOREIGN KEY(groups_id) REFERENCES cloudnote_group(groups_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(user_id) REFERENCES cloudnote_user(user_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户小组成员表';

DROP TABLE IF EXISTS cloudnote_group_notepage;
CREATE TABLE cloudnote_group_notepage (
    group_notepage_id int AUTO_INCREMENT PRIMARY KEY,
    groups_id int NOT NULL COMMENT '笔记页属组id',
    notepage_id int NOT NULL COMMENT '笔记页id',
    FOREIGN KEY(groups_id) REFERENCES cloudnote_group(groups_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(notepage_id) REFERENCES cloudnote_notepage(notepage_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户小组笔记页表';
