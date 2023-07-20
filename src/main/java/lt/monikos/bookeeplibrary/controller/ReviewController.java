package lt.monikos.bookeeplibrary.controller;

import lt.monikos.bookeeplibrary.requestmodels.ReviewRequest;
import lt.monikos.bookeeplibrary.service.ReviewService;
import lt.monikos.bookeeplibrary.utils.ExtractJWT;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("api/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController (ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/secure/user/book")
    public Boolean reviewBookByUser(@RequestHeader(value="Authorization") String token,
                                    @RequestParam Long bookId) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");

        if (userEmail == null) {
            throw new Exception("User email is missing");
        }
        return reviewService.userReviewListed(userEmail, bookId);
    }


    @PostMapping("/secure")
    public void postReview(@RequestHeader(value = "Authorization") String token,
                             @RequestBody ReviewRequest reviewRequest) throws Exception  {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        if(userEmail == null) {
            throw new Exception("User email is missing");
        }
        reviewService.postReview(userEmail, reviewRequest);
    }
}