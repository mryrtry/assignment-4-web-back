package org.mryrt.web.PointCheck.Controller;

import jakarta.validation.Valid;
import org.mryrt.web.PointCheck.Model.Result;
import org.mryrt.web.PointCheck.Model.ResultUploadRequest;
import org.mryrt.web.PointCheck.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/points")
@CrossOrigin
@Lazy
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping
    public ResponseEntity uploadPoint(@Valid @RequestBody ResultUploadRequest resultUploadRequest) {
        Result result = resultService.uploadResult(resultUploadRequest);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity getAllPoints() {
        return ResponseEntity.ok(resultService.getAllResults());
    }

    @DeleteMapping
    public ResponseEntity deleteAllPoints() {
        resultService.deleteAllResults();
        return ResponseEntity.ok().build();
    }

}
