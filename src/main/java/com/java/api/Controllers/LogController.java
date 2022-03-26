package com.java.api.Controllers;

import com.java.api.DTOs.GeneralRes;
import com.java.api.DTOs.ReportSingleBattleId;
import com.java.api.Entities.*;
import com.java.api.Respositories.*;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.util.Date;
import java.util.List;

@Controller("/api/v1/log")
public class LogController {

    @Inject
    private BattleIdsRepository battleIdsRepository;

    @Inject
    private BenchesRepository benchesRepository;

    @Inject
    private MovesRepository movesRepository;

    @Inject
    private FaintsRepository faintsRepository;

    @Inject
    private WinnersRepository winnersRepository;

    @Get("/create/battleid")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<BattleId> createBattleId () {
        String uuid = battleIdsRepository.createUUID();
        return HttpResponse.ok(new BattleId(uuid, new Date()));
    }

    @Post("/save/benches")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> saveLog (@Body Benches benches) {
        benchesRepository.saveBenches(benches);
        return HttpResponse.ok(new GeneralRes());
    }

    @Post("/save/move")
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse<?> saveLog (@Body Moves moves) {
        movesRepository.saveMove(moves);
        return HttpResponse.ok(new GeneralRes());
    }

    @Post("/save/faints")
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse<?> saveLog (@Body Faints faints) {
        faintsRepository.saveFaint(faints);
        return HttpResponse.ok(new GeneralRes());
    }

    @Post("/save/winner")
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse<?> saveWinner (@Body Winner winner) {
        winnersRepository.saveWinner(winner);
        return HttpResponse.ok(new GeneralRes());
    }

    @Get("/retrieve/battle")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> retrieveBattleLogs (@QueryValue String battleId) {

        List<Moves> moves = movesRepository.getMovesByBattleId(battleId);
        List<Faints> faints = faintsRepository.getFaintsByBattleId(battleId);
        Winner winner = winnersRepository.getWinnerByBattleId(battleId);

        return HttpResponse.ok(new ReportSingleBattleId(moves, faints, winner));
    }

}
