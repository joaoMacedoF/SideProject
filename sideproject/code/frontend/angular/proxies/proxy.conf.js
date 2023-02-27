module.exports = {
  "/api": {
    target: "http://localhost:8080",
    secure: false,
    logLevel: "debug",
    pathRewrite: {
      "^/api": "/my-project-rest/api",
    },
  },
};
