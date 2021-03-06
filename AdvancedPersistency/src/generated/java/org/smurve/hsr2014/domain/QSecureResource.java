package org.smurve.hsr2014.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSecureResource is a Querydsl query type for SecureResource
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSecureResource extends EntityPathBase<SecureResource> {

    private static final long serialVersionUID = 1478361131L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSecureResource secureResource = new QSecureResource("secureResource");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath id = _super.id;

    public final StringPath owner = createString("owner");

    public final QTenant tenant;

    //inherited
    public final StringPath uniqueName = _super.uniqueName;

    public QSecureResource(String variable) {
        this(SecureResource.class, forVariable(variable), INITS);
    }

    public QSecureResource(Path<? extends SecureResource> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSecureResource(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSecureResource(PathMetadata metadata, PathInits inits) {
        this(SecureResource.class, metadata, inits);
    }

    public QSecureResource(Class<? extends SecureResource> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tenant = inits.isInitialized("tenant") ? new QTenant(forProperty("tenant")) : null;
    }

}

