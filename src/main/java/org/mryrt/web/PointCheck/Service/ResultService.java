package org.mryrt.web.PointCheck.Service;

import lombok.extern.slf4j.Slf4j;
import org.mryrt.web.Auth.Service.UserService;
import org.mryrt.web.PointCheck.Exception.InvalidResultUpload;
import org.mryrt.web.PointCheck.Model.Result;
import org.mryrt.web.PointCheck.Model.ResultUploadRequest;
import org.mryrt.web.PointCheck.Repository.ResultRepository;
import org.mryrt.web.PointCheck.Validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private UserService userService;

    public Result uploadResult(ResultUploadRequest resultUploadRequest) {
        log.info("Processing point: {}", resultUploadRequest);
        long requestProcessStart = System.nanoTime();

        if (!Validator.validateParams(resultUploadRequest))
            throw new InvalidResultUpload("Invalid parameters");

        Result result = new Result();

        result.setX(resultUploadRequest.getX());
        result.setY(resultUploadRequest.getY());
        result.setR(resultUploadRequest.getR());
        result.setInArea(Validator.checkPointInArea(resultUploadRequest));
        result.setCreatedById(userService.userGetMe().getId());
        result.setProcessingTime(System.nanoTime() - requestProcessStart);

        return resultRepository.save(result);
    }

    public List<Result> getAllResults() {
        long authUserId = userService.userGetMe().getId();
        log.info("Getting all results for user: {}", authUserId);
        return resultRepository
                .findAll()
                .stream()
                .filter(result -> result.getCreatedById() == authUserId)
                .toList();
    }

    public void deleteAllResults() {
        long authUserId = userService.userGetMe().getId();
        log.info("Deleting all results for user: {}", authUserId);
        resultRepository.deleteAllByUserId(authUserId);
    }

}
