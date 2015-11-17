package org.smurve.hsr2014.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTenant is a Querydsl query type for Tenant
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTenant extends EntityPathBase<Tenant> {

    private static final long serialVersionUID = 1024700976L;

    public static final QTenant tenant = new QTenant("tenant");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath id = _super.id;

    public final StringPath tenantId = createString("tenantId");

    //inherited
    public final StringPath uniqueName = _super.uniqueName;

    public QTenant(String variable) {
        super(Tenant.class, forVariable(variable));
    }

    public QTenant(Path<? extends Tenant> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTenant(PathMetadata metadata) {
        super(Tenant.class, metadata);
    }

}

