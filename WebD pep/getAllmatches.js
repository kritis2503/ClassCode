let request=require("request");
let cheerio=require("cheerio");

function getAllMatches(link)
{
    request(link,cb);
}
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
    let allTags=ch('a[data-hover="Scorecard"]');

    for(let i=0;i<allTags.length;i++)
    {
        let link=ch(allTags[i]).attr("href");
        let completeLink="https://www.espncricinfo.com"+link;

    }
}
module.exports.getAllMatches=getAllMatches;

