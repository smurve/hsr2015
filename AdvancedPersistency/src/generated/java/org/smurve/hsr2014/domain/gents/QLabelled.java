package org.smurve.hsr2014.domain.gents;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLabelled is a Querydsl query type for Labelled
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QLabelled extends EntityPathBase<Labelled> {

    private static final long serialVersionUID = 1985039196L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLabelled labelled = new QLabelled("labelled");

    public final org.smurve.hsr2014.domain.QBaseEntity _super = new org.smurve.hsr2014.domain.QBaseEntity(this);

    //inherited
    public final StringPath id = _super.id;

    public final QGentsLabel label;

    //inherited
    public final StringPath uniqueName = _super.uniqueName;

    public QLabelled(String variable) {
        this(Labelled.class, forVariable(variable), INITS);
    }

    public QLabelled(Path<? extends Labelled> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QLabelled(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QLabelled(PathMetadata metadata, PathInits inits) {
        this(Labelled.class, metadata, inits);
    }

    public QLabelled(Class<? extends Labelled> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.label = inits.isInitialized("label") ? new QGentsLabel(forProperty("label")) : null;
    }

}

