/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */
package com.as.springbook.config;

import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

import com.as.springbook.annotation.TestData;

/**
 * @author komatsu
 *
 */
public class AbstractTestExecutionListenerComponent implements TestExecutionListener {

	private IDatabaseTester dbunitTester;
	
	public void afterTestClass(TestContext arg0) throws Exception {
		// TODO Auto-generated method stub		
	}

	public void afterTestMethod(TestContext arg0) throws Exception {
		if (dbunitTester != null) {			
			dbunitTester.onTearDown();
		}				
	}

	public void beforeTestClass(TestContext arg0) throws Exception {
		// TODO Auto-generated method stub		
	}

	public void beforeTestMethod(TestContext testCtx) throws Exception {

		TestData dataSetAnnotation = testCtx.getTestMethod().getAnnotation(TestData.class);	
		String dataSetName = dataSetAnnotation.setTestDataSource();

		if ( ! dataSetName.equals("") ) {
			dbunitTester = (IDatabaseTester) testCtx.getApplicationContext().getBean("dbunitTester");
			XlsDataFileLoader xlsDataFileLoader = (XlsDataFileLoader) testCtx.getApplicationContext().getBean("xlsDataFileLoader");
			IDataSet dataSet = xlsDataFileLoader.load(dataSetName);
	
			dbunitTester.setDataSet(dataSet);	
			dbunitTester.onSetup();
		}
	}

	public void prepareTestInstance(TestContext arg0) throws Exception {
		// TODO Auto-generated method stub
	}	


	
}
