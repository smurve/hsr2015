package org.smurve.hsr2014.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResourceAccessRule is a Querydsl query type for ResourceAccessRule
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QResourceAccessRule extends EntityPathBase<ResourceAccessRule> {

    private static final long serialVersionUID = 253134260L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResourceAccessRule resourceAccessRule = new QResourceAccessRule("resourceAccessRule");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath id = _super.id;

    public final EnumPath<EntityOperation> operation = createEnum("operation", EntityOperation.class);

    public final SimplePath<Class<? extends BaseEntity>> resourceType = createSimple("resourceType", Class.class);

    public final QRole role;

    //inherited
    public final StringPath uniqueName = _super.uniqueName;

    public QResourceAccessRule(String variable) {
        this(ResourceAccessRule.class, forVariable(variable), INITS);
    }

    public QResourceAccessRule(Path<? extends ResourceAccessRule> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QResourceAccessRule(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QResourceAccessRule(PathMetadata metadata, PathInits inits) {
        this(ResourceAccessRule.class, metadata, inits);
    }

    public QResourceAccessRule(Class<? extends ResourceAccessRule> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.role = inits.isInitialized("role") ? new QRole(forProperty("role"), inits.get("role")) : null;
    }

}

