package com.globalin.biz.common;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

//    트랜잭션 관리자 등록(스프링은 트랜잭션 관리자를 지원함)
//    어떤 기술을 이용하여 데이터베이스 연동을 처리했느냐에 따라 트랜잭션 관리자가 달라짐 

public interface PlatformTransactionManager {

	TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException;
	void commit(TransactionStatus status) throws TransactionException;
	void rollback(TransactionStatus status) throws TransactionException;
	
}