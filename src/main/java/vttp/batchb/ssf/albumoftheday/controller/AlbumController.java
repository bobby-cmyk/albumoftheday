package vttp.batchb.ssf.albumoftheday.controller;

import java.io.File;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path={"/", "/index"})
public class AlbumController {

    @GetMapping()
    public String getIndex(Model model) {

        model.addAttribute("albumCoverPath", getRandomAlbumCoverPath());
        
        return "album_of_the_day";
    }

    private String getRandomAlbumCoverPath() {

        File albumFolder = new File("src/main/resources/static/albumcovers");

        File[] albumCovers = albumFolder.listFiles();

        Random random = new Random();

        int index = random.nextInt(albumCovers.length);

        String randomAlbumName = albumCovers[index].getName();

        return "/albumcovers/%s".formatted(randomAlbumName);
    }


}
