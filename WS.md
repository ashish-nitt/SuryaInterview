# Goal

The purpose of these exercises is for the interviewer to get a sense of how you write code and english. This shouldn’t take you more than a few hours to get done. If you already have code on Github or Bitbucket, or a blog that you feel is representative of your current abilities, you can send me a link to those instead of doing these exercises.

## Writing exercise

The point of this exercise is to benchmark your writing skills.

Write an approximately 500 word article about something you're passionate about that's technology related. It doesn't really matter what the topic is. For instance, you can write about a [language feature](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html) you like or dislike, something in the [news](http://david-smith.org/blog/2014/11/18/initial-impressions-for-watchkit/), [something](http://daringfireball.net/2014/11/native_apps_are_part_of_the_web) that you have an opinion about, etc.



## Code exercise

The point of this exercise is to benchmark your ability to write code. Although this is a toy problem, please make sure your solution is of production quality. You should be comfortable checking your solution into your primary code base. Use proper names, check for errors, etc. Your code should be representative of how you code on the job.


### Constraints

- Your solution must be written in either Java (preferred) or Python.
- You may use any libraries and tools of your choice.
- You must provide a solution that can be run on a unix system (preferably OS X 10.10, but any unix system will do).
- You must provide instructions on how to build and run your code.


### Submission

The expected submission method is a Github or Bitbucket repository. Please email me a link. If you'd like to use a private repo and give me read access, that's perfectly fine. My username on Github and Bitbucket is `gps`.

If that's not an option (please explain why), email me a zip file.


### Problem

A JSON over HTTP API is deployed at `http://surya-interview.appspot.com`. The goal is to performance test it. This involves making two requests.

The first request is an HTTP `GET` request to `http://surya-interview.appspot.com/message` that contains a header titled `X-Surya-Email-Id`. This must contain your email address. The response will be a HTTP 200 (unless there's an error - if it's a 400 class error, you did something wrong; if it's a 500 class error, please let me know via email) and contain a JSON body which has the email id you sent as a header, as well as a uuid. Example:

```
200 OK
{
  "emailId": "gps@surya-soft.com",
  "uuid": "fa674442-c513-4b1f-8dce-47f70307143c"
}
```

The second request is an HTTP `POST` request to `http://surya-interview.appspot.com/message`. The post body must be JSON and must have two keys: `emailId` (exactly the same value as you sent before), and `uuid` (the value that was returned in the previous response). Example:

```
{
  "emailId": "gps@surya-soft.com",
  "uuid": "fa674442-c513-4b1f-8dce-47f70307143c"
}
```

The response if successful will be a HTTP 200, with a body that reads `Success`. If you get a 400 class error you did something wrong. If you get a 500 class error, please let me know via email.

You are expected to make each of these requests 100 times and provide the following statistics for the response time of each API:

- 10th percentile
- 50th percentile
- 90th percentile
- 95th percentile
- 99th percentile
- Mean
- Standard Deviation

Please note that your solution *must be* concurrent. That is, you cannot make 200 requests in sequence. You should be making at least 10 requests at a time. Obviously, since one of the requests requires data from the previous response, you will have to do those in sequence.


# Contact

If there's anything you're uncertain about and need clarification, please feel free to reach out to me at gps@surya-soft.com.
