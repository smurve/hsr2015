/**
 * This class is generated by jOOQ
 */
package test.generated.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import test.generated.Hsr2015;
import test.generated.Keys;
import test.generated.tables.records.AuthorRecord;


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
public class Author extends TableImpl<AuthorRecord> {

	private static final long serialVersionUID = -82303345;

	/**
	 * The reference instance of <code>hsr2015.Author</code>
	 */
	public static final Author AUTHOR = new Author();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<AuthorRecord> getRecordType() {
		return AuthorRecord.class;
	}

	/**
	 * The column <code>hsr2015.Author.id</code>.
	 */
	public final TableField<AuthorRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>hsr2015.Author.category</code>.
	 */
	public final TableField<AuthorRecord, String> CATEGORY = createField("category", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>hsr2015.Author.firstName</code>.
	 */
	public final TableField<AuthorRecord, String> FIRSTNAME = createField("firstName", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>hsr2015.Author.lastName</code>.
	 */
	public final TableField<AuthorRecord, String> LASTNAME = createField("lastName", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * Create a <code>hsr2015.Author</code> table reference
	 */
	public Author() {
		this("Author", null);
	}

	/**
	 * Create an aliased <code>hsr2015.Author</code> table reference
	 */
	public Author(String alias) {
		this(alias, AUTHOR);
	}

	private Author(String alias, Table<AuthorRecord> aliased) {
		this(alias, aliased, null);
	}

	private Author(String alias, Table<AuthorRecord> aliased, Field<?>[] parameters) {
		super(alias, Hsr2015.HSR2015, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<AuthorRecord, Long> getIdentity() {
		return Keys.IDENTITY_AUTHOR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<AuthorRecord> getPrimaryKey() {
		return Keys.KEY_AUTHOR_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<AuthorRecord>> getKeys() {
		return Arrays.<UniqueKey<AuthorRecord>>asList(Keys.KEY_AUTHOR_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Author as(String alias) {
		return new Author(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Author rename(String name) {
		return new Author(name, null);
	}
}
