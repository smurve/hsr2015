package org.smurve.hsr2014.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuditRecord is a Querydsl query type for AuditRecord
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAuditRecord extends EntityPathBase<AuditRecord> {

    private static final long serialVersionUID = -1133666746L;

    public static final QAuditRecord auditRecord = new QAuditRecord("auditRecord");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath arg = createString("arg");

    public final StringPath classifier = createString("classifier");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath objectId = createString("objectId");

    public final StringPath repo = createString("repo");

    //inherited
    public final StringPath uniqueName = _super.uniqueName;

    public final StringPath user = createString("user");

    public QAuditRecord(String variable) {
        super(AuditRecord.class, forVariable(variable));
    }

    public QAuditRecord(Path<? extends AuditRecord> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuditRecord(PathMetadata metadata) {
        super(AuditRecord.class, metadata);
    }

}

