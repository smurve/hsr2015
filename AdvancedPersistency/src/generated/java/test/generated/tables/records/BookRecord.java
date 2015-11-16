/**
 * This class is generated by jOOQ
 */
package test.generated.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;

import test.generated.tables.Book;


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
public class BookRecord extends UpdatableRecordImpl<BookRecord> implements Record5<Long, String, String, Long, Double> {

	private static final long serialVersionUID = 1650743659;

	/**
	 * Setter for <code>hsr2015.Book.id</code>.
	 */
	public void setId(Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>hsr2015.Book.id</code>.
	 */
	public Long getId() {
		return (Long) getValue(0);
	}

	/**
	 * Setter for <code>hsr2015.Book.category</code>.
	 */
	public void setCategory(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>hsr2015.Book.category</code>.
	 */
	public String getCategory() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>hsr2015.Book.title</code>.
	 */
	public void setTitle(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>hsr2015.Book.title</code>.
	 */
	public String getTitle() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>hsr2015.Book.author_id</code>.
	 */
	public void setAuthorId(Long value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>hsr2015.Book.author_id</code>.
	 */
	public Long getAuthorId() {
		return (Long) getValue(3);
	}

	/**
	 * Setter for <code>hsr2015.Book.price</code>.
	 */
	public void setPrice(Double value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>hsr2015.Book.price</code>.
	 */
	public Double getPrice() {
		return (Double) getValue(4);
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
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row5<Long, String, String, Long, Double> fieldsRow() {
		return (Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row5<Long, String, String, Long, Double> valuesRow() {
		return (Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field1() {
		return Book.BOOK.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Book.BOOK.CATEGORY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return Book.BOOK.TITLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field4() {
		return Book.BOOK.AUTHOR_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Double> field5() {
		return Book.BOOK.PRICE;
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
		return getTitle();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value4() {
		return getAuthorId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double value5() {
		return getPrice();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BookRecord value1(Long value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BookRecord value2(String value) {
		setCategory(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BookRecord value3(String value) {
		setTitle(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BookRecord value4(Long value) {
		setAuthorId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BookRecord value5(Double value) {
		setPrice(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BookRecord values(Long value1, String value2, String value3, Long value4, Double value5) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached BookRecord
	 */
	public BookRecord() {
		super(Book.BOOK);
	}

	/**
	 * Create a detached, initialised BookRecord
	 */
	public BookRecord(Long id, String category, String title, Long authorId, Double price) {
		super(Book.BOOK);

		setValue(0, id);
		setValue(1, category);
		setValue(2, title);
		setValue(3, authorId);
		setValue(4, price);
	}
}
