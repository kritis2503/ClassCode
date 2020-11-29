let request=require("request");
let cheerio=require("cheerio");

let link="https://www.espncricinfo.com/series/8048/scorecard/1237181/delhi-capitals-vs-mumbai-indians-final-indian-premier-league-2020-21";
request( link , cb);

function cb(error,reponse,data)
{
    if(error==null && reponse==200)
        parseData(data);
    else if(reponse.statusCode==404)
        console.log("Page not Found");
    else    console.log("Error");
}
function parseData(html){
    let ch=cheerio.load(html);
    let bothinnings=ch('.card.content-block.match-scorecard-table .Collapsible');
    for(let i=0 ; i<bothInnings.length ; i++){
        let teamName = ch(bothInnings[i]).find(".header-title.label").text().split("Innings")[0].trim();
        // Delhi Capitals Innings (20 overs maximum)
        //[  "Delhi Capitals " , " (20 overs maximum)" ];
        console.log(teamName);
    }
}