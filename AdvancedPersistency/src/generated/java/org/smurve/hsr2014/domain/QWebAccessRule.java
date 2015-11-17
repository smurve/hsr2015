package org.smurve.hsr2014.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWebAccessRule is a Querydsl query type for WebAccessRule
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWebAccessRule extends EntityPathBase<WebAccessRule> {

    private static final long serialVersionUID = 793022638L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWebAccessRule webAccessRule = new QWebAccessRule("webAccessRule");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath applicationPart = createString("applicationPart");

    //inherited
    public final StringPath id = _super.id;

    public final QRole role;

    //inherited
    public final StringPath uniqueName = _super.uniqueName;

    public final StringPath url = createString("url");

    public QWebAccessRule(String variable) {
        this(WebAccessRule.class, forVariable(variable), INITS);
    }

    public QWebAccessRule(Path<? extends WebAccessRule> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QWebAccessRule(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QWebAccessRule(PathMetadata metadata, PathInits inits) {
        this(WebAccessRule.class, metadata, inits);
    }

    public QWebAccessRule(Class<? extends WebAccessRule> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.role = inits.isInitialized("role") ? new QRole(forProperty("role"), inits.get("role")) : null;
    }

}

