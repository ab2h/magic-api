package org.ssssssss.magicapi.modules;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.ssssssss.script.annotation.Comment;
import org.ssssssss.script.annotation.UnableCall;

/**
 * 事务模块
 */
public class Transaction {

	@UnableCall
	private DataSourceTransactionManager dataSourceTransactionManager;

	@UnableCall
	private TransactionStatus transactionStatus;

	@UnableCall
	private static final TransactionDefinition TRANSACTION_DEFINITION = new DefaultTransactionDefinition();

	public Transaction(DataSourceTransactionManager dataSourceTransactionManager) {
		this.dataSourceTransactionManager = dataSourceTransactionManager;
		this.transactionStatus = dataSourceTransactionManager.getTransaction(TRANSACTION_DEFINITION);
	}

	/**
	 * 回滚事务
	 */
	@Comment("回滚事务")
	public void rollback(){
		this.dataSourceTransactionManager.rollback(this.transactionStatus);
	}

	/**
	 * 提交事务
	 */
	@Comment("提交事务")
	public void commit(){
		this.dataSourceTransactionManager.commit(this.transactionStatus);
	}
}
