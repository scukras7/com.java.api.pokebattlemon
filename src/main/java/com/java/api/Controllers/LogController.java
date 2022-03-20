package com.java.api.Controllers;

import com.java.api.DTOs.*;
import com.java.api.Entities.BattleId;
import com.java.api.Respositories.BattleIdsRepository;
import com.java.api.Respositories.BenchesRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import javax.print.attribute.standard.Media;
import java.util.Date;

@Controller("/api/v1/log")
public class LogController {

    @Inject
    private BattleIdsRepository battleIdsRepository;

    @Inject
    private BenchesRepository benchesRepository;

    @Get("/create/battleid")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<BattleId> createBattleId () {
        String uuid = battleIdsRepository.createUUID();
        return HttpResponse.ok(new BattleId(uuid, new Date()));
    }

    @Post("/save/benches")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> saveLog (@Body BenchesReq benchesReq) {
        benchesRepository.saveBenches(benchesReq);
        return HttpResponse.ok(new GeneralRes());
    }

    @Post("/save/move")
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse<?> saveLog (@Body MoveReq moveReq) {
        System.out.println("MOVE");
        System.out.println(moveReq);
        return HttpResponse.ok(new GeneralRes());
    }

    /*

    @Post("/save/faints")
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse<?> saveLog (@Body FaintsReq faintsReq) {}

    @Post("/save/winner")
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse<?> saveWinner (@Body WinnerReq winnerReq) {}

    */
}
