package org.smurve.hsr2014.domain2;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProject is a Querydsl query type for Project
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProject extends EntityPathBase<Project> {

    private static final long serialVersionUID = -582432011L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProject project = new QProject("project");

    public final QSecureResource _super;

    //inherited
    public final StringPath id;

    public final StringPath name = createString("name");

    //inherited
    public final StringPath owner;

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    // inherited
    public final QTenant tenant;

    //inherited
    public final StringPath TenantId;

    //inherited
    public final StringPath uniqueName;

    public QProject(String variable) {
        this(Project.class, forVariable(variable), INITS);
    }

    public QProject(Path<? extends Project> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProject(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QProject(PathMetadata metadata, PathInits inits) {
        this(Project.class, metadata, inits);
    }

    public QProject(Class<? extends Project> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QSecureResource(type, metadata, inits);
        this.id = _super.id;
        this.owner = _super.owner;
        this.tenant = _super.tenant;
        this.TenantId = _super.TenantId;
        this.uniqueName = _super.uniqueName;
    }

}

