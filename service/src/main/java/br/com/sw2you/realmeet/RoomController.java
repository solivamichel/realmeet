package br.com.sw2you.realmeet;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import br.com.sw2you.realmeet.api.facade.RoomsApi;
import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;


@RestController
public class RoomController implements RoomsApi {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public CompletableFuture<ResponseEntity<RoomDTO>> getRoom(Long id) {
        return supplyAsync(() -> ResponseEntity.ok(roomService.getRoom(id)));
    }
}
