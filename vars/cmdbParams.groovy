import groovy.json.JsonSlurper

def call(String cmdbEndpoint, Map additionalParams = [:]) {
    try {
        echo "Fetching parameters from CMDB endpoint: ${cmdbEndpoint}"

        // Fetch CMDB data
        def response = httpRequest(
            url: cmdbEndpoint,
            httpMode: 'GET',
            contentType: 'APPLICATION_JSON'
        )
        def cmdbData = new JsonSlurper().parseText(response.content)

        // Merge CMDB data with additional parameters
        def finalParams = cmdbData + additionalParams

        echo "Final Parameters: ${finalParams}"
        return finalParams
    } catch (Exception e) {
        error "Failed to fetch parameters from CMDB: ${e.message}"
    }
}
