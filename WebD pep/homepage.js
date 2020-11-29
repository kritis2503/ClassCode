let request=require("request");
let fs=require("fs");
let cheerio=require("cheerio");

let link="https://www.espncricinfo.com/series/_/id/8048/season/2020/indian-premier-league";
request(link,cb);

function cb(error,reponse,data)
{
    if(error==null && reponse==200)
        parseData(data);
    else if(reponse.statusCode==404)
        console.log("Page not Found");
    else    console.log("Error");
}
function parseData(html)
{
    let ch=cheerio.load(html);
    let link = ch('.widget-items.cta-link a').attr("href");
    let completeLink = "https://www.espncricinfo.com"+link;
    console.log(completeLink);
    getAllMatches(completeLink);
}