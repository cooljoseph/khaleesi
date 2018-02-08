package com.kakaocorp.commerce.khaleesi.base.entity.schedule;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScheduleWork is a Querydsl query type for ScheduleWork
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QScheduleWork extends EntityPathBase<ScheduleWork> {

    private static final long serialVersionUID = -172690778L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QScheduleWork scheduleWork = new QScheduleWork("scheduleWork");

    public final StringPath description = createString("description");

    public final StringPath endDttm = createString("endDttm");

    public final StringPath errorMsg = createString("errorMsg");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QSchedule schedule;

    public final StringPath startDttm = createString("startDttm");

    public final StringPath status = createString("status");

    public final QWorker worker;

    public QScheduleWork(String variable) {
        this(ScheduleWork.class, forVariable(variable), INITS);
    }

    public QScheduleWork(Path<? extends ScheduleWork> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QScheduleWork(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QScheduleWork(PathMetadata metadata, PathInits inits) {
        this(ScheduleWork.class, metadata, inits);
    }

    public QScheduleWork(Class<? extends ScheduleWork> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.schedule = inits.isInitialized("schedule") ? new QSchedule(forProperty("schedule")) : null;
        this.worker = inits.isInitialized("worker") ? new QWorker(forProperty("worker")) : null;
    }

}

