import groovy.json.JsonSlurper

/**
 * Fetch parameters from the CMDB service.
 * 
 * @param cmdbEndpoint URL of the CMDB API endpoint.
 * @param additionalParams A Map of additional parameters to merge with the CMDB response.
 * @return A Map containing the final parameters.
 */
def call(String cmdbEndpoint, Map additionalParams = [:]) {
    try {
        echo "Fetching parameters from CMDB endpoint: ${cmdbEndpoint}"

        // Make an HTTP GET request to the CMDB API
        def response = httpRequest(
            url: cmdbEndpoint,
            httpMode: 'GET',
            contentType: 'APPLICATION_JSON'
        )
        def cmdbData = new JsonSlurper().parseText(response.content)

        // Merge CMDB parameters with additional ones
        def finalParams = cmdbData + additionalParams

        echo "Retrieved Parameters from CMDB: ${finalParams}"
        return finalParams
    } catch (Exception e) {
        error "Error fetching parameters from CMDB: ${e.message}"
    }
}
