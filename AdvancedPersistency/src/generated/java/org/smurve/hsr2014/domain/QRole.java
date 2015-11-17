package org.smurve.hsr2014.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = -1885015172L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRole role = new QRole("role");

    public final QSecureResource _super;

    //inherited
    public final StringPath id;

    //inherited
    public final StringPath owner;

    public final StringPath roleName = createString("roleName");

    // inherited
    public final QTenant tenant;

    //inherited
    public final StringPath uniqueName;

    public QRole(String variable) {
        this(Role.class, forVariable(variable), INITS);
    }

    public QRole(Path<? extends Role> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRole(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRole(PathMetadata metadata, PathInits inits) {
        this(Role.class, metadata, inits);
    }

    public QRole(Class<? extends Role> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QSecureResource(type, metadata, inits);
        this.id = _super.id;
        this.owner = _super.owner;
        this.tenant = _super.tenant;
        this.uniqueName = _super.uniqueName;
    }

}

