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
import org.smurve.hsr2014.jooq.tables.Author;


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
public class AuthorRecord extends UpdatableRecordImpl<AuthorRecord> implements Record4<Long, String, String, String> {

	private static final long serialVersionUID = -1776753967;

	/**
	 * Setter for <code>hsr2015.Author.id</code>.
	 */
	public void setId(Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>hsr2015.Author.id</code>.
	 */
	public Long getId() {
		return (Long) getValue(0);
	}

	/**
	 * Setter for <code>hsr2015.Author.category</code>.
	 */
	public void setCategory(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>hsr2015.Author.category</code>.
	 */
	public String getCategory() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>hsr2015.Author.firstName</code>.
	 */
	public void setFirstname(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>hsr2015.Author.firstName</code>.
	 */
	public String getFirstname() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>hsr2015.Author.lastName</code>.
	 */
	public void setLastname(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>hsr2015.Author.lastName</code>.
	 */
	public String getLastname() {
		return (String) getValue(3);
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
	public Row4<Long, String, String, String> fieldsRow() {
		return (Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Long, String, String, String> valuesRow() {
		return (Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field1() {
		return Author.AUTHOR.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Author.AUTHOR.CATEGORY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return Author.AUTHOR.FIRSTNAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return Author.AUTHOR.LASTNAME;
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
		return getCategory();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getFirstname();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getLastname();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AuthorRecord value1(Long value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AuthorRecord value2(String value) {
		setCategory(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AuthorRecord value3(String value) {
		setFirstname(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AuthorRecord value4(String value) {
		setLastname(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AuthorRecord values(Long value1, String value2, String value3, String value4) {
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
	 * Create a detached AuthorRecord
	 */
	public AuthorRecord() {
		super(Author.AUTHOR);
	}

	/**
	 * Create a detached, initialised AuthorRecord
	 */
	public AuthorRecord(Long id, String category, String firstname, String lastname) {
		super(Author.AUTHOR);

		setValue(0, id);
		setValue(1, category);
		setValue(2, firstname);
		setValue(3, lastname);
	}
}
