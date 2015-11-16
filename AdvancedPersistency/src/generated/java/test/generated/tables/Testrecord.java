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
import test.generated.tables.records.TestrecordRecord;


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
public class Testrecord extends TableImpl<TestrecordRecord> {

	private static final long serialVersionUID = -185239159;

	/**
	 * The reference instance of <code>hsr2015.TestRecord</code>
	 */
	public static final Testrecord TESTRECORD = new Testrecord();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<TestrecordRecord> getRecordType() {
		return TestrecordRecord.class;
	}

	/**
	 * The column <code>hsr2015.TestRecord.id</code>.
	 */
	public final TableField<TestrecordRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>hsr2015.TestRecord.firstArg</code>.
	 */
	public final TableField<TestrecordRecord, String> FIRSTARG = createField("firstArg", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>hsr2015.TestRecord.innerOrOuter</code>.
	 */
	public final TableField<TestrecordRecord, String> INNEROROUTER = createField("innerOrOuter", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>hsr2015.TestRecord.secondArg</code>.
	 */
	public final TableField<TestrecordRecord, String> SECONDARG = createField("secondArg", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * Create a <code>hsr2015.TestRecord</code> table reference
	 */
	public Testrecord() {
		this("TestRecord", null);
	}

	/**
	 * Create an aliased <code>hsr2015.TestRecord</code> table reference
	 */
	public Testrecord(String alias) {
		this(alias, TESTRECORD);
	}

	private Testrecord(String alias, Table<TestrecordRecord> aliased) {
		this(alias, aliased, null);
	}

	private Testrecord(String alias, Table<TestrecordRecord> aliased, Field<?>[] parameters) {
		super(alias, Hsr2015.HSR2015, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<TestrecordRecord, Long> getIdentity() {
		return Keys.IDENTITY_TESTRECORD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<TestrecordRecord> getPrimaryKey() {
		return Keys.KEY_TESTRECORD_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<TestrecordRecord>> getKeys() {
		return Arrays.<UniqueKey<TestrecordRecord>>asList(Keys.KEY_TESTRECORD_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Testrecord as(String alias) {
		return new Testrecord(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Testrecord rename(String name) {
		return new Testrecord(name, null);
	}
}
