/**
 * This class is generated by jOOQ
 */
package org.smurve.hsr2014.jooq.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;
import org.smurve.hsr2014.jooq.tables.Account;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AccountRecord extends UpdatableRecordImpl<AccountRecord> implements Record4<Long, String, Double, Long> {

	private static final long serialVersionUID = -470544284;

	/**
	 * Setter for <code>hsr2015.Account.id</code>.
	 */
	public void setId(Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>hsr2015.Account.id</code>.
	 */
	public Long getId() {
		return (Long) getValue(0);
	}

	/**
	 * Setter for <code>hsr2015.Account.accountNumber</code>.
	 */
	public void setAccountnumber(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>hsr2015.Account.accountNumber</code>.
	 */
	public String getAccountnumber() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>hsr2015.Account.amount</code>.
	 */
	public void setAmount(Double value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>hsr2015.Account.amount</code>.
	 */
	public Double getAmount() {
		return (Double) getValue(2);
	}

	/**
	 * Setter for <code>hsr2015.Account.accountOwner_id</code>.
	 */
	public void setAccountownerId(Long value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>hsr2015.Account.accountOwner_id</code>.
	 */
	public Long getAccountownerId() {
		return (Long) getValue(3);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Long> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Long, String, Double, Long> fieldsRow() {
		return (Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Long, String, Double, Long> valuesRow() {
		return (Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field1() {
		return Account.ACCOUNT.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Account.ACCOUNT.ACCOUNTNUMBER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Double> field3() {
		return Account.ACCOUNT.AMOUNT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field4() {
		return Account.ACCOUNT.ACCOUNTOWNER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getAccountnumber();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double value3() {
		return getAmount();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value4() {
		return getAccountownerId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AccountRecord value1(Long value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AccountRecord value2(String value) {
		setAccountnumber(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AccountRecord value3(Double value) {
		setAmount(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AccountRecord value4(Long value) {
		setAccountownerId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AccountRecord values(Long value1, String value2, Double value3, Long value4) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached AccountRecord
	 */
	public AccountRecord() {
		super(Account.ACCOUNT);
	}

	/**
	 * Create a detached, initialised AccountRecord
	 */
	public AccountRecord(Long id, String accountnumber, Double amount, Long accountownerId) {
		super(Account.ACCOUNT);

		setValue(0, id);
		setValue(1, accountnumber);
		setValue(2, amount);
		setValue(3, accountownerId);
	}
}