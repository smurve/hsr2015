package org.smurve.hsr2014.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccessRule is a Querydsl query type for AccessRule
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccessRule extends EntityPathBase<AccessRule> {

    private static final long serialVersionUID = 1713374470L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccessRule accessRule = new QAccessRule("accessRule");

    public final QSecureResource _super;

    public final EnumPath<Action> action = createEnum("action", Action.class);

    //inherited
    public final StringPath id;

    //inherited
    public final StringPath owner;

    public final QSecureResource resource;

    public final QRole role;

    // inherited
    public final QTenant tenant;

    //inherited
    public final StringPath uniqueName;

    public QAccessRule(String variable) {
        this(AccessRule.class, forVariable(variable), INITS);
    }

    public QAccessRule(Path<? extends AccessRule> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAccessRule(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAccessRule(PathMetadata metadata, PathInits inits) {
        this(AccessRule.class, metadata, inits);
    }

    public QAccessRule(Class<? extends AccessRule> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QSecureResource(type, metadata, inits);
        this.id = _super.id;
        this.owner = _super.owner;
        this.resource = inits.isInitialized("resource") ? new QSecureResource(forProperty("resource"), inits.get("resource")) : null;
        this.role = inits.isInitialized("role") ? new QRole(forProperty("role"), inits.get("role")) : null;
        this.tenant = _super.tenant;
        this.uniqueName = _super.uniqueName;
    }

}

