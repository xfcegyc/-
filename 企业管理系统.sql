CREATE TABLE users_role(
userId INTEGER,
roleId INTEGER,
PRIMARY KEY(userId,roleId),
FOREIGN KEY (userId) REFERENCES users(id),
FOREIGN KEY (roleId) REFERENCES role(id)
)

CREATE TABLE role_permission(
permissionId INTEGER,
roleId INTEGER,
PRIMARY KEY(permissionId,roleId),
FOREIGN KEY (permissionId) REFERENCES permission(id),
FOREIGN KEY (roleId) REFERENCES role(id)
)

dos�����д���mysql����
�������
�޸� client��connection��results �ı���Ϊ GBK����֤�� DOS �����б��뱣��һ��
��������  ˵��
set character_set_client=gbk;  �޸Ŀͻ��˵��ַ���Ϊ GBK
set character_set_connection=gbk;  �޸����ӵ��ַ���Ϊ GBK
set character_set_results=gbk;  �޸Ĳ�ѯ�Ľ���ַ���Ϊ GBK