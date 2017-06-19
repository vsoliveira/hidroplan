package com.hidroplan.application.persistence;

import java.sql.Types;

import org.hibernate.dialect.MySQL5Dialect;

public class MySQLDialect extends MySQL5Dialect {
	public MySQLDialect() {
		super();
		registerColumnType(Types.NUMERIC, "decimal(30,0)");
	}
}
