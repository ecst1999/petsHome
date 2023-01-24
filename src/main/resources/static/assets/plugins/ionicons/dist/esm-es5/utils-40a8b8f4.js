import{g as getAssetPath}from"./index-14843ae0.js";var CACHED_MAP;var getIconMap=function(){if(typeof window==="undefined"){return new Map}else{if(!CACHED_MAP){var t=window;t.Ionicons=t.Ionicons||{};CACHED_MAP=t.Ionicons.map=t.Ionicons.map||new Map}return CACHED_MAP}};var addIcons=function(t){var r=getIconMap();Object.keys(t).forEach((function(e){return r.set(e,t[e])}))};var getUrl=function(t){var r=getSrc(t.src);if(r){return r}r=getName(t.name,t.icon,t.mode,t.ios,t.md);if(r){return getNamedUrl(r)}if(t.icon){r=getSrc(t.icon);if(r){return r}r=getSrc(t.icon[t.mode]);if(r){return r}}return null};var getNamedUrl=function(t){var r=getIconMap().get(t);if(r){return r}return getAssetPath("svg/".concat(t,".svg"))};var getName=function(t,r,e,n,i){e=(e&&toLower(e))==="ios"?"ios":"md";if(n&&e==="ios"){t=toLower(n)}else if(i&&e==="md"){t=toLower(i)}else{if(!t&&r&&!isSrc(r)){t=r}if(isStr(t)){t=toLower(t)}}if(!isStr(t)||t.trim()===""){return null}var o=t.replace(/[a-z]|-|\d/gi,"");if(o!==""){return null}return t};var getSrc=function(t){if(isStr(t)){t=t.trim();if(isSrc(t)){return t}}return null};var isSrc=function(t){return t.length>0&&/(\/|\.)/.test(t)};var isStr=function(t){return typeof t==="string"};var toLower=function(t){return t.toLowerCase()};var inheritAttributes=function(t,r){if(r===void 0){r=[]}var e={};r.forEach((function(r){if(t.hasAttribute(r)){var n=t.getAttribute(r);if(n!==null){e[r]=t.getAttribute(r)}t.removeAttribute(r)}}));return e};export{addIcons as a,inheritAttributes as b,getName as c,getUrl as g,isStr as i};