package org.smurve.hsr2014.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomer is a Querydsl query type for Customer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCustomer extends EntityPathBase<Customer> {

    private static final long serialVersionUID = -1191968796L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCustomer customer = new QCustomer("customer");

    public final QSecureResource _super;

    public final StringPath customerId = createString("customerId");

    public final StringPath firstName = createString("firstName");

    //inherited
    public final StringPath id;

    public final StringPath lastName = createString("lastName");

    //inherited
    public final StringPath owner;

    // inherited
    public final QTenant tenant;

    //inherited
    public final StringPath uniqueName;

    public QCustomer(String variable) {
        this(Customer.class, forVariable(variable), INITS);
    }

    public QCustomer(Path<? extends Customer> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCustomer(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCustomer(PathMetadata metadata, PathInits inits) {
        this(Customer.class, metadata, inits);
    }

    public QCustomer(Class<? extends Customer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QSecureResource(type, metadata, inits);
        this.id = _super.id;
        this.owner = _super.owner;
        this.tenant = _super.tenant;
        this.uniqueName = _super.uniqueName;
    }

}

