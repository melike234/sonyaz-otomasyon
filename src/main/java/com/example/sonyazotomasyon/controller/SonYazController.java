package com.example.sonyazotomasyon.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "*")
public class SonYazController {

    // Karakterler ve açıklamaları
    private final Map<String, String> karakterBilgileri = Map.of(
            "Selim Kara", "Adaletin pesinde, sert gorunumlu ama yufka yurekli bir lider.",
            "Akgun Gokalp Taskin", "Firtinali, sadik ve sevdikleri icin dunyayi yakacak biri.",
            "Canan Kara", "Zarif, guclu ve ailesini her seye ragmen ayakta tutan direk.",
            "Yagmur Kara", "Inatci, duygusal ve dogrularindan asla vazgecmeyen bir savaşçı.",
            "Soner Sancaktar", "Racon sahibi, dostuna mert, dusmanina sert bir sırdaş."
    );

    @PostMapping("/sonuc")
    public Map<String, String> hesapla(@RequestBody Map<String, Integer> puanlar) {
        // En yuksek puani alan karakteri bulma mantigi (Basitce simule edilmistir)
        String[] isimler = {"Selim Kara", "Akgun Gokalp Taskin", "Canan Kara", "Yagmur Kara", "Soner Sancaktar"};
        int maxIndex = (puanlar.get("puan") % isimler.length);
        String karakter = isimler[maxIndex];

        return Map.of(
                "karakter", karakter,
                "aciklama", karakterBilgileri.get(karakter)
        );
    }
}