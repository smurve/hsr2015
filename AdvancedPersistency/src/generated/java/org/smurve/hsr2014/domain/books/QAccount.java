package org.smurve.hsr2014.domain.books;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = -1784254813L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccount account = new QAccount("account");

    public final StringPath accountNumber = createString("accountNumber");

    public final QAuthor accountOwner;

    public final NumberPath<Double> amount = createNumber("amount", Double.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QAccount(String variable) {
        this(Account.class, forVariable(variable), INITS);
    }

    public QAccount(Path<? extends Account> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAccount(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAccount(PathMetadata metadata, PathInits inits) {
        this(Account.class, metadata, inits);
    }

    public QAccount(Class<? extends Account> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.accountOwner = inits.isInitialized("accountOwner") ? new QAuthor(forProperty("accountOwner")) : null;
    }

}

