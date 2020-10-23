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

dos命令行窗口mysql乱码
解决方案
修改 client、connection、results 的编码为 GBK，保证和 DOS 命令行编码保持一致
单独设置  说明
set character_set_client=gbk;  修改客户端的字符集为 GBK
set character_set_connection=gbk;  修改连接的字符集为 GBK
set character_set_results=gbk;  修改查询的结果字符集为 GBK