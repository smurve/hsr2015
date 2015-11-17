package org.smurve.hsr2014.domain2;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1774573935L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final QSecureResource _super;

    public final BooleanPath active = createBoolean("active");

    //inherited
    public final StringPath id;

    //inherited
    public final StringPath owner;

    public final StringPath password = createString("password");

    public final SetPath<Role, QRole> roles = this.<Role, QRole>createSet("roles", Role.class, QRole.class, PathInits.DIRECT2);

    // inherited
    public final QTenant tenant;

    //inherited
    public final StringPath TenantId;

    //inherited
    public final StringPath uniqueName;

    public final StringPath username = createString("username");

    public final NumberPath<Integer> wrongPasswordCounter = createNumber("wrongPasswordCounter", Integer.class);

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUser(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QSecureResource(type, metadata, inits);
        this.id = _super.id;
        this.owner = _super.owner;
        this.tenant = _super.tenant;
        this.TenantId = _super.TenantId;
        this.uniqueName = _super.uniqueName;
    }

}

