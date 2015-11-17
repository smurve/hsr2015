package org.smurve.hsr2014.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QContract is a Querydsl query type for Contract
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QContract extends EntityPathBase<Contract> {

    private static final long serialVersionUID = 1929875736L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QContract contract = new QContract("contract");

    public final QSecureResource _super;

    public final StringPath contractId = createString("contractId");

    public final EnumPath<ContractType> contractType = createEnum("contractType", ContractType.class);

    public final QCustomer customer;

    //inherited
    public final StringPath id;

    //inherited
    public final StringPath owner;

    // inherited
    public final QTenant tenant;

    //inherited
    public final StringPath uniqueName;

    public QContract(String variable) {
        this(Contract.class, forVariable(variable), INITS);
    }

    public QContract(Path<? extends Contract> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QContract(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QContract(PathMetadata metadata, PathInits inits) {
        this(Contract.class, metadata, inits);
    }

    public QContract(Class<? extends Contract> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QSecureResource(type, metadata, inits);
        this.customer = inits.isInitialized("customer") ? new QCustomer(forProperty("customer"), inits.get("customer")) : null;
        this.id = _super.id;
        this.owner = _super.owner;
        this.tenant = _super.tenant;
        this.uniqueName = _super.uniqueName;
    }

}

