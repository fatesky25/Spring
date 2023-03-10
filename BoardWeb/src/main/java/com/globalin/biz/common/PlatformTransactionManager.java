package com.globalin.biz.common;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

//    Ʈ����� ������ ���(�������� Ʈ����� �����ڸ� ������)
//    � ����� �̿��Ͽ� �����ͺ��̽� ������ ó���ߴ��Ŀ� ���� Ʈ����� �����ڰ� �޶��� 

public interface PlatformTransactionManager {

	TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException;
	void commit(TransactionStatus status) throws TransactionException;
	void rollback(TransactionStatus status) throws TransactionException;
	
}