$headers = New-Object "System.Collections.Generic.Dictionary[[String],[String]]"
$headers.Add("Content-Type", "application/json")

$body = "{`n    `n   `"surname`": `"Kowalska`",`n   `"name`" : `"Monika`",`n   `"username`" : `"MONA000`",`n   `"seatDto`" : [{`n    `"columnNumber`":2,`n    `"rowNumber`": 1,`n    `"ticketTypes`" : `"ADULT`",`n    `"repertoireDto`":{`n        `"id`":13`n    }`n   }`n]`n}"

$response = Invoke-RestMethod 'http://localhost:8080/seats/reserve' -Method 'POST' -Headers $headers -Body $body
$response | ConvertTo-Json